export class CurrentUser {
  id: number;
  name: string;
  email: string;
  tel: string;
  points: number;
  enable: boolean;

  constructor ( obj?: any) {
    this.id = obj && obj.id || 0;
    this.name = obj && obj.name || '';
    this.email = obj && obj.email || '';
    this.tel = obj && obj.tel || '';
    this.points = obj && obj.points || 0;
    this.enable = obj && obj.enable || false;
  }

  setPoints(p: number) {
    this.points = p;
  }

  getPoints() {
    return this.points;
  }

}
