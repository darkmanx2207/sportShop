import {AfterViewInit, Component, ElementRef, Input, OnInit, ViewChild} from '@angular/core';
import {ProteinService} from '../../service/Protein.service';
import {Protein} from '../../model/Protein';
import {EditGeneralInfoComponent} from '../../edit-general/edit-general-info/edit-general-info.component';
import {DataService} from '../../service/DataService';
import {DomSanitizer} from '@angular/platform-browser';
import {jsPDF} from 'jspdf';

@Component({
  selector: 'app-protein',
  templateUrl: './protein.component.html',
  styleUrls: ['./protein.component.css']
})
export class ProteinComponent implements OnInit {

  @Input() item: string;
  @ViewChild(EditGeneralInfoComponent, null) test;
  @ViewChild('htmlData', null) htmlData: ElementRef;
  protein: Protein;
  imageSTR: any;
  image: { 'image': string };

  constructor(private proteinService: ProteinService,
              private sharedData: DataService,
              private sanitizer: DomSanitizer) {
  }

  ngOnInit() {
    if (this.protein !== null && this.imageSTR !== null) {
      this.getProtein();
      this.getProteinImage();
    }
  }

  getProtein() {
    this.proteinService.getProtein(this.sharedData.sharedData).subscribe(async x => {
        this.protein = x;
        console.log(this.protein);
      }
    );
  }

  getProteinImage() {
    this.proteinService.getProteinImage(this.sharedData.sharedData).subscribe(x => {
      this.image = x;
      this.imageSTR = this.sanitizer.bypassSecurityTrustResourceUrl('data:image/jpg;base64,'
        + this.image.image);
    });
  }

  openPDF() {
    const DATA = this.htmlData.nativeElement.innerText;
    const DATAP = this.protein;

    const doc = new jsPDF();
    // doc.html(this.testAAA);
    // doc.output('dataurlnewwindow');
    // doc.html(DATA.innerHTML);
    // doc.text(DATA.innerHTML, 10, 10);
    // const eee = doc.html(DATA.innerHTML);
    // doc.text(DATA, 10, 10);
    /*doc.text(this.protein.name + '\n'
    + this.protein.price + '\n' + this.protein.description + '\n' +
      this.protein.taste, 10, 10);*/
    const splitTitle = doc.splitTextToSize(this.protein.name + '\n'
      + this.protein.price + '\n' + this.protein.description + '\n' +
      this.protein.taste, 180);
    doc.text(splitTitle, 15, 10);
    doc.save('a4.pdf');

  }
}
