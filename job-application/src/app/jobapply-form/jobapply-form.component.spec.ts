import { ComponentFixture, TestBed } from '@angular/core/testing';

import { JobapplyFormComponent } from './jobapply-form.component';

describe('JobapplyFormComponent', () => {
  let component: JobapplyFormComponent;
  let fixture: ComponentFixture<JobapplyFormComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [JobapplyFormComponent]
    });
    fixture = TestBed.createComponent(JobapplyFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
