export class CurrentUser {
  id: number;
  username: string;
  firstname: string;
  lastname: string;
  email: string;
  phone: string;
  wallet?: number;
  spent_points?: number;
  profit?: number;
  businessName?: string;
  bankAccount?: string;
  rights_code?: number;
  enable: boolean;
  mode: string;

  constructor ( obj?: any) {
    this.id = obj && obj.id || 0;
    this.firstname = obj && obj.firstname || '';
    this.lastname = obj && obj.lastname || '';
    this.email = obj && obj.email || '';
    this.phone = obj && obj.phone || '';
    this.enable = obj && obj.enable || false;
    this.mode = obj && obj.mode || '';
    if (obj && obj.wallet) {
      this.wallet = obj.wallet;
    }
    if (obj && obj.spent_points) {
      this.spent_points = obj.spent_points;
    }
    if (obj && obj.profit) {
      this.profit = obj.profit;
    }
    if (obj && obj.businessName) {
      this.businessName = obj.businessName;
    }
    if (obj && obj.bankAccount) {
      this.bankAccount = obj.bankAccount;
    }
    if (obj && obj.rights_code) {
      this.rights_code = obj.rights_code;
    }
  }
}
