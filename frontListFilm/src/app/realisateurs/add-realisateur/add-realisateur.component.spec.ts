import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddRealisateurComponent } from './add-realisateur.component';

describe('AddRealisateurComponent', () => {
  let component: AddRealisateurComponent;
  let fixture: ComponentFixture<AddRealisateurComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddRealisateurComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddRealisateurComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
