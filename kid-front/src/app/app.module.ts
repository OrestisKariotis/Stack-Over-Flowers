import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { UserLoginComponent } from './user-login/user-login.component';
import { ParentRegisterComponent } from './parent-register/parent-register.component';
import { ProviderRegisterComponent } from './provider-register/provider-register.component';
import { ConfirmPasswordDirective } from './directives/confirm-password.directive';

import { fakeBackendProvider } from './helpers/fakebackend';
import { HTTP_INTERCEPTORS } from '@angular/common/http';

import { UserLoginService } from './services/user-login.service';
import { CurrentUserService } from './services/current-user.service';
import { ParentRegisterService } from './services/parent-register.service';
import { ProviderRegisterService } from './services/provider-register.service';
import { EventRegisterService } from './services/event-register.service';

import { FaqComponent } from './faq/faq.component';
import { AboutUsComponent } from './about-us/about-us.component';
import { ContactComponent } from './contact/contact.component';
import { ErrorComponent } from './error/error.component';
import { TermsComponent } from './terms/terms.component';
import { PointsComponent } from './points/points.component';
import { ParentProfileComponent } from './parent-profile/parent-profile.component';
import { ProviderProfileComponent } from './provider-profile/provider-profile.component';
import { AdminLoginComponent } from './admin-login/admin-login.component';
import { ControlPanelComponent } from './control-panel/control-panel.component';
import { EventRegisterComponent } from './event-register/event-register.component';
import { SearchComponent } from './search/search.component';



@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    UserLoginComponent,
    ParentRegisterComponent,
    ProviderRegisterComponent,
    ConfirmPasswordDirective,
    FaqComponent,
    AboutUsComponent,
    ContactComponent,
    ErrorComponent,
    TermsComponent,
    PointsComponent,
    ParentProfileComponent,
    ProviderProfileComponent,
    AdminLoginComponent,
    ControlPanelComponent,
    EventRegisterComponent,
    SearchComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [
    UserLoginService,
    CurrentUserService,
    ParentRegisterService,
    ProviderRegisterService,
    EventRegisterService,
    fakeBackendProvider
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
