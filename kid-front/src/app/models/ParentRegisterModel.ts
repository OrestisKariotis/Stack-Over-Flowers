export class ParentRegisterModel {
  username: string;
  password: string;
  firstname: string;
  lastname: string;
  email: string;
  phone: string;
  enable: boolean;

  constructor ( obj?: any) {
    this.username = obj && obj.username || '';
    this.password = obj && obj.password || '';
    this.firstname = obj && obj.firstname || '';
    this.lastname = obj && obj.lastname || '';
    this.email = obj && obj.email || '';
    this.phone = obj && obj.phone || '';
    this.enable = obj && obj.error || false;
  }

}
