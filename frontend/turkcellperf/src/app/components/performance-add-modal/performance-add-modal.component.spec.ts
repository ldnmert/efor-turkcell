import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PerformanceAddModalComponent } from './performance-add-modal.component';

describe('PerformanceAddModalComponent', () => {
  let component: PerformanceAddModalComponent;
  let fixture: ComponentFixture<PerformanceAddModalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [PerformanceAddModalComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(PerformanceAddModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
