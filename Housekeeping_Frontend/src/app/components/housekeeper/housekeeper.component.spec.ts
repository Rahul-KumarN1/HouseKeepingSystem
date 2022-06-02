import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HousekeeperComponent } from './housekeeper.component';

describe('HousekeeperComponent', () => {
  let component: HousekeeperComponent;
  let fixture: ComponentFixture<HousekeeperComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HousekeeperComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HousekeeperComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
