import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AccountsAccordionComponent } from './accounts-accordion.component';

describe('AccountsAccordionComponent', () => {
  let component: AccountsAccordionComponent;
  let fixture: ComponentFixture<AccountsAccordionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AccountsAccordionComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AccountsAccordionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
