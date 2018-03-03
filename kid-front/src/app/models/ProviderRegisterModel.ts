export class ProviderRegisterModel {
  username: string;
  password: string;
  firstname: string;
  lastname: string;
  businessName: string;
  email: string;
  phone: string;
  bankAccount: string;
  enable: boolean;

  constructor ( obj?: any) {
    this.username = obj && obj.username || '';
    this.password = obj && obj.password || '';
    this.firstname = obj && obj.firstName || '';
    this.lastname = obj && obj.lastName || '';
    this.businessName = obj && obj.orgName || '';
    this.email = obj && obj.email || '';
    this.phone = obj && obj.phone || '';
    this.bankAccount = obj && obj.bankAccount || '';
    this.enable = obj && obj.error || false;
  }

}
