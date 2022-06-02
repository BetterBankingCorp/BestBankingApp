import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WithdrawDepositTransferComponent } from './withdraw-deposit-transfer.component';

describe('WithdrawDepositTransferComponent', () => {
  let component: WithdrawDepositTransferComponent;
  let fixture: ComponentFixture<WithdrawDepositTransferComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ WithdrawDepositTransferComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(WithdrawDepositTransferComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
