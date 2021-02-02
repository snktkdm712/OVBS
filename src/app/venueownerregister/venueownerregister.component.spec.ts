import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VenueownerregisterComponent } from './venueownerregister.component';

describe('VenueownerregisterComponent', () => {
  let component: VenueownerregisterComponent;
  let fixture: ComponentFixture<VenueownerregisterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VenueownerregisterComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(VenueownerregisterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
