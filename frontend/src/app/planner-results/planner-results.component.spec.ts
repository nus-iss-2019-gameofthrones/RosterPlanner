import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PlannerResultsComponent } from './planner-results.component';

describe('PlannerResultsComponent', () => {
  let component: PlannerResultsComponent;
  let fixture: ComponentFixture<PlannerResultsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PlannerResultsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PlannerResultsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
