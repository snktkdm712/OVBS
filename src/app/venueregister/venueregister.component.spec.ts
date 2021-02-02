import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VenueregisterComponent } from './venueregister.component';

describe('VenueregisterComponent', () => {
  let component: VenueregisterComponent;
  let fixture: ComponentFixture<VenueregisterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VenueregisterComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(VenueregisterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
