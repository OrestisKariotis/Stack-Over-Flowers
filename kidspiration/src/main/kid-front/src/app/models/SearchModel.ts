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

    this.description = obj && obj.freetext || null;
    this.distanceInKm = obj && obj.dist || null;
    this.fromLoc = obj && obj.position || null;
    this.dateLower = obj && obj.startdate || null;
    this.dateUpper = obj && obj.enddate || null;
    this.lowerCost = obj && obj.lowpoints || null;
    this.upperCost = obj && obj.highpoints || null;
    this.age = obj && obj.age || null;
    this.categories = obj && obj.categories || null;
  }
}
