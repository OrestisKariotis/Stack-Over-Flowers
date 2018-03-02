export class SearchModel {

  freetext?: string;
  dist?: number;
  position?: string;
  startdate?: string;
  enddate?: string;
  lowpoints?: number;
  highpoints?: number;
  age?: number;
  categories?: string[];

  constructor(obj?: any) {
    if (obj && obj.freetext) {
      this.freetext = obj.freetext;
    }
    if (obj && obj.dist) {
      this.dist = obj.dist;
    }
    if (obj && obj.wallet) {
      this.position = obj.position;
    }
    if (obj && obj.wallet) {
      this.startdate = obj.startdate;
    }
    if (obj && obj.wallet) {
      this.enddate = obj.enddate;
    }
    if (obj && obj.lowpoints) {
      this.lowpoints = obj.lowpoints;
    }
    if (obj && obj.highpoints) {
      this.highpoints = obj.highpoints;
    }
    if (obj && obj.age) {
      this.age = obj.age;
    }
    if (obj && obj.categories) {
      this.categories = obj.categories;
    }
  }
}
