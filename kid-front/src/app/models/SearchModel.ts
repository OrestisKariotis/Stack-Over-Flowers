export class SearchModel {

  description?: string;
  distanceInKm?: number;
  fromLoc?: string;
  dateLower?: string;
  dateUpper?: string;
  lowerCost?: number;
  upperCost?: number;
  age?: number;
  categories?: string[];

  constructor(obj?: any) {
    if (obj && obj.freetext) {
      this.description = obj.freetext;
    }
    if (obj && obj.dist) {
      this.distanceInKm = obj.dist;
    }
    if (obj && obj.position) {
      this.fromLoc = obj.position;
    }
    if (obj && obj.startdate) {
      this.dateLower = obj.startdate;
    }
    if (obj && obj.enddate) {
      this.dateUpper = obj.enddate;
    }
    if (obj && obj.lowpoints) {
      this.lowerCost = obj.lowpoints;
    }
    if (obj && obj.highpoints) {
      this.upperCost = obj.highpoints;
    }
    if (obj && obj.age) {
      this.age = obj.age;
    }
    if (obj && obj.categories) {
      this.categories = obj.categories;
    }
  }
}
