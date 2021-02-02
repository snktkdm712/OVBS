import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { AboutusComponent } from './aboutus/aboutus.component';
import { AdminregisterComponent } from './adminregister/adminregister.component';
import { CustomerregisterComponent } from './customerregister/customerregister.component';
import { VenueownerregisterComponent } from './venueownerregister/venueownerregister.component';
import { AdminComponent } from './admin/admin.component';
import { CustomerComponent } from './customer/customer.component';
import { VownerComponent } from './vowner/vowner.component';
import { ContactusComponent } from './contactus/contactus.component';
import { HomeComponent } from './home/home.component';
import { VenueregisterComponent } from './venueregister/venueregister.component';
import { VenueComponent } from './venue/venue.component';
import { CityComponent } from './city/city.component';
import { LocationComponent } from './location/location.component';
import { VlocationComponent } from './vlocation/vlocation.component';
import { BookingComponent } from './booking/booking.component';
import { AuthGuard } from './auth.guard';


const routes: Routes = [{path:'',component:HomeComponent},
{path:'login',component:LoginComponent},
{path:'aboutus',component:AboutusComponent},
{path:'radmin',component:AdminregisterComponent},
{path:'rcustomer',component:CustomerregisterComponent},
{path:'rvowner',component:VenueownerregisterComponent},
{path:'admin',component:AdminComponent},
{path:'customer',component:CustomerComponent},
{path:'vowner',component:VownerComponent},
{path:'contactus',component:ContactusComponent},
{path:'city',component:CityComponent},
{path:'location',component:LocationComponent},
{path:'venue/:vname',component:VenueComponent},
{path:'rvenue',component:VenueregisterComponent},
{path:'vloc/:n',component:VlocationComponent},
{path:'book',component:BookingComponent}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
