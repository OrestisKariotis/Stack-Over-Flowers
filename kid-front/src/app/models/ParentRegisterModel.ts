export class ParentRegisterModel {
  username: string;
  password: string;
  firstName: string;
  lastName: string;
  email: string;
  phone: string;
  enable: boolean;

  constructor ( obj?: any) {
    this.username = obj && obj.username || '';
    this.password = obj && obj.password || '';
    this.firstName = obj && obj.firstName || '';
    this.lastName = obj && obj.lastName || '';
    this.email = obj && obj.email || '';
    this.phone = obj && obj.phone || '';
    this.enable = obj && obj.error || false;
  }

}
