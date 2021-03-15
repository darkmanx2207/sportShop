import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { UserService } from './service/User.service';
import { EditGeneralInfoComponent } from './edit-general/edit-general-info/edit-general-info.component';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {
  MatButtonModule,
  MatFormFieldModule,
  MatGridListModule,
  MatIconModule,
  MatInputModule,
  MatMenuModule,
  MatToolbarModule
} from '@angular/material';

import {Routes, RouterModule} from '@angular/router';
import { LoginComponent } from './login/login.component';
import {NotFoundComponent} from './not-found.component';
import {LocationStrategy, PathLocationStrategy} from '@angular/common';
import { RegisterComponent } from './login/register/register.component';
import { ProteinComponent } from './entity/protein/protein.component';
import {ProteinService} from './service/Protein.service';
import {DataService} from './service/DataService';
import { ServiceWorkerModule } from '@angular/service-worker';
import { environment } from '../environments/environment';
import { ProteinsComponent } from './entity/proteins/proteins.component';

const appRoutes: Routes = [
  { path: 'login', component: LoginComponent},
  { path: '', component: EditGeneralInfoComponent},
  { path: 'register', component: RegisterComponent},
  { path: 'protein', component: ProteinComponent},
  { path: 'proteins', component: ProteinsComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    EditGeneralInfoComponent,
    LoginComponent,
    NotFoundComponent,
    RegisterComponent,
    ProteinComponent,
    ProteinsComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatIconModule,
    MatButtonModule,
    MatFormFieldModule,
    MatInputModule,
    ReactiveFormsModule,
    RouterModule.forRoot(appRoutes),
    MatMenuModule,
    ServiceWorkerModule.register('ngsw-worker.js', {enabled: environment.production}),
    MatGridListModule
  ],
  providers: [UserService, ProteinService, DataService],
  bootstrap: [AppComponent]
})
export class AppModule { }
