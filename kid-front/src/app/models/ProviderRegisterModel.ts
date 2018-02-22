export class ProviderRegisterModel {
  username: string;
  password: string;
  firstName: string;
  lastName: string;
  orgName: string;
  email: string;
  phone: string;
  bankNumber: string;
  enable: boolean;

  constructor ( obj?: any) {
    this.username = obj && obj.username || '';
    this.password = obj && obj.password || '';
    this.firstName = obj && obj.firstName || '';
    this.lastName = obj && obj.lastName || '';
    this.orgName = obj && obj.orgName || '';
    this.email = obj && obj.email || '';
    this.phone = obj && obj.phone || '';
    this.bankNumber = obj && obj.bankNumber || '';
    this.enable = obj && obj.error || false;
  }

}
