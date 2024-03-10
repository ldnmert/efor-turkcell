import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PerformanceTableComponent } from './components/performance-table/performance-table.component';
import { RouterModule, Routes } from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
import { PerformanceAddModalComponent } from './components/performance-add-modal/performance-add-modal.component';
import { HeaderComponent } from './components/header/header.component';
import { AdminpanelComponent } from './components/adminpanel/adminpanel.component';

import { SideBarComponent } from './components/side-bar/side-bar.component';
import { UserComponent } from './components/user/user.component';
import { LoginComponent } from './components/login/login.component';



import { UnauthorizedComponent } from './components/unauthorized/unauthorized.component';







const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'performance-table', component: PerformanceTableComponent },
    { path: 'admin-table', component: AdminpanelComponent },
{ path: 'unauthorized', component: UnauthorizedComponent}, 

    { path: '', redirectTo: '/login', pathMatch: 'full' }, // Varsayılan olarak login sayfasına yönlendir
    { path: '**', redirectTo: '/login' }, // Geçersiz URL'lerde de login sayfasına yönlendir
    
   
];
@NgModule({
  declarations: [ 
    AppComponent,
    PerformanceTableComponent,
    PerformanceAddModalComponent,
    HeaderComponent,
    AdminpanelComponent,
    SideBarComponent,
    UserComponent,
    LoginComponent,
    
  
    
    

  
  
  ],
  imports: [
   RouterModule.forRoot(routes),
    FormsModule,
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,

 

  ],

  providers: [
    provideClientHydration(),
    provideAnimationsAsync(),
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
