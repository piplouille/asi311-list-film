import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateRealisateurComponent } from './update-realisateur.component';

describe('UpdateRealisateurComponent', () => {
  let component: UpdateRealisateurComponent;
  let fixture: ComponentFixture<UpdateRealisateurComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateRealisateurComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateRealisateurComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
