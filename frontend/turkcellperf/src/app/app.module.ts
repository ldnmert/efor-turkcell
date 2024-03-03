import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PerformanceTableComponent } from './components/performance-table/performance-table.component';
import { RouterModule, Routes } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
import { PerformanceAddModalComponent } from './components/performance-add-modal/performance-add-modal.component';
import { HeaderComponent } from './components/header/header.component';
import { AdminpanelComponent } from './components/adminpanel/adminpanel.component';



const routes: Routes = [
  { path: '', component: PerformanceTableComponent }, // Ana sayfa performans tablosu
  { path: 'admin', component: AdminpanelComponent } // Admin girişi için ayrı sayfa
];
@NgModule({
  declarations: [
    AppComponent,
    PerformanceTableComponent,
    PerformanceAddModalComponent,
    HeaderComponent,
    AdminpanelComponent
  
  ],
  imports: [
    // RouterModule.forRoot(routes),
    FormsModule,
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    [RouterModule.forRoot(routes)]
  ],
  providers: [
    provideClientHydration(),
    provideAnimationsAsync()
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
