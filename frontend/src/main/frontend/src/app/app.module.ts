import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { UserService } from './service/User.service';
import { EditGeneralInfoComponent } from './edit-general/edit-general-info/edit-general-info.component';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatButtonModule, MatFormFieldModule, MatIconModule, MatInputModule, MatMenuModule, MatToolbarModule} from '@angular/material';

import {Routes, RouterModule} from '@angular/router';
import { LoginComponent } from './login/login.component';
import {NotFoundComponent} from './not-found.component';
import {LocationStrategy, PathLocationStrategy} from '@angular/common';
import { RegisterComponent } from './login/register/register.component';
import { ProteinComponent } from './entity/protein/protein.component';

const appRoutes: Routes = [
  { path: 'login', component: LoginComponent},
  { path: '', component: EditGeneralInfoComponent},
  { path: 'register', component: RegisterComponent},
  { path: 'protein', component: ProteinComponent},
];

@NgModule({
  declarations: [
    AppComponent,
    EditGeneralInfoComponent,
    LoginComponent,
    NotFoundComponent,
    RegisterComponent,
    ProteinComponent
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
    MatMenuModule
  ],
  providers: [UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }
