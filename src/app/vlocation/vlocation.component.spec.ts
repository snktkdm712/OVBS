import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VlocationComponent } from './vlocation.component';

describe('VlocationComponent', () => {
  let component: VlocationComponent;
  let fixture: ComponentFixture<VlocationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VlocationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(VlocationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
