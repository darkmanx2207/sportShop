import {Component, OnInit} from '@angular/core';
import {ProteinService} from '../../service/Protein.service';
import {Protein} from '../../model/Protein';
import {TableRequest} from '../../model/TableRequest';
import {DomSanitizer} from '@angular/platform-browser';
import {DataService} from '../../service/DataService';

@Component({
  selector: 'app-proteins',
  templateUrl: './proteins.component.html',
  styleUrls: ['./proteins.component.css']
})
export class ProteinsComponent implements OnInit {

  tableRequest: TableRequest = new TableRequest();
  proteins: Protein[] = [];
  image: { 'image': string };

  constructor(private proteinService: ProteinService,
              private sanitizer: DomSanitizer,
              private sharedData: DataService) {
  }

  ngOnInit() {
    this.showListofItems();
  }

  showListofItems() {
    this.tableRequest.type = this.sharedData.type;
    this.proteinService.getListofProteins(this.tableRequest).subscribe(protein => {
      this.proteins = protein;
      console.log(this.proteins);

      this.proteins.forEach(prot => {
        this.proteinService.getProteinImage(prot.id).subscribe(photoOfprotein => {
          this.image = photoOfprotein;
          prot.photo = this.sanitizer.bypassSecurityTrustResourceUrl('data:image/jpg;base64,'
            + this.image.image);
        });
      });
    });
  }

  openPDF(id: number) {
    this.proteinService.getPDF(id).subscribe();
  }



  /*openPDF() {
    // const DATA = this.htmlData.nativeElement.innerText;
    // const DATAP = this.protein;

    const doc = new jsPDF();
    // doc.html(this.testAAA);
    // doc.output('dataurlnewwindow');
    // doc.html(DATA.innerHTML);
    // doc.text(DATA.innerHTML, 10, 10);
    // const eee = doc.html(DATA.innerHTML);
    // doc.text(DATA, 10, 10);
    doc.text(this.protein.name + '\n'
    + this.protein.price + '\n' + this.protein.description + '\n' +
      this.protein.taste, 10, 10);

    this.proteins.forEach(pr => {



    const splitTitle = doc.splitTextToSize(pr.price + '\n'
      + pr.taste + '\n' + pr.type + '\n' +
      pr.name, 180);
    doc.text(splitTitle, 15, 10);
    doc.save('a4.pdf');
    });
  }*/
}
