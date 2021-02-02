import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VownerComponent } from './vowner.component';

describe('VownerComponent', () => {
  let component: VownerComponent;
  let fixture: ComponentFixture<VownerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VownerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(VownerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
