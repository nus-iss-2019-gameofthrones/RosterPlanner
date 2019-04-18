import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { NavigationComponent } from './navigation/navigation.component';
import { EmployeesComponent } from './employees/employees.component';
import { NotFoundComponent } from './not-found/not-found.component';
import {Router, Routes, RouterModule} from "@angular/router";
import { SkillsComponent } from './skills/skills.component';
import { StationsComponent } from './stations/stations.component';
import { PlannerComponent } from './planner/planner.component';
import { FormsModule } from "@angular/forms";
import { config } from 'rxjs';
import {HttpClientModule} from "@angular/common/http";
import { CreateEmployeeComponent } from './create-employee/create-employee.component';
import { ViewEmployeeComponent } from './view-employee/view-employee.component';
import { CreateStationComponent } from './create-station/create-station.component';
import { ViewStationComponent } from './view-station/view-station.component';
import { DatePickerModule} from '@syncfusion/ej2-angular-calendars';
import {DataTableModule} from "angular-6-datatable";
import { PlannerResultsComponent } from './planner-results/planner-results.component';

const appRoutes :Routes = [
  {
    path:'employees',
    component:EmployeesComponent
  },
  {
    path:'',
    component:EmployeesComponent,
    pathMatch:'full'
  },
  {
    path:'skills',
    component:SkillsComponent
  },
  {
    path:'stations',
    component:StationsComponent
  },
  {
    path:'planner',
    component:PlannerComponent
  },
  {
    path:'create',
    component:CreateEmployeeComponent
  },
  {
    path:'viewEmployee/:id',
    component:ViewEmployeeComponent
  },
  {
    path:'createStation',
    component:CreateStationComponent
  },
  {
    path:'viewStation/:id',
    component:ViewStationComponent
  },
  {
    path:'plannerResults/:assignments',
    component:PlannerResultsComponent
  },
  {
    path:'**',
    component:NotFoundComponent
  }
];

@NgModule({
  declarations: [
    AppComponent,
    NavigationComponent,
    EmployeesComponent,
    NotFoundComponent,
    SkillsComponent,
    StationsComponent,
    PlannerComponent,
    CreateEmployeeComponent,
    ViewEmployeeComponent,
    CreateStationComponent,
    ViewStationComponent,
    PlannerResultsComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(appRoutes, {enableTracing:true}),
    FormsModule,
    HttpClientModule,
    DatePickerModule,
    DataTableModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
