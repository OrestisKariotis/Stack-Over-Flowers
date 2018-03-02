export class PointsPurchaseModel {
  id: number;
  pointsCode: number;
  paymentType: string;
  cardNumber: string;
  expireDate: string;
  CRC: string;
  firstName: string;
  lastName: string;
  address: string;
  city: string;
  phone: string;

  constructor(obj?: any) {
    this.id = obj && obj.id || 0;
    this.pointsCode = obj && obj.pointsCode || 0;
    this.paymentType = obj && obj.paymentType || '';
    this.cardNumber = obj && obj.cardNumber || '';
    this.expireDate = obj && obj.expireDate || '';
    this.CRC = obj && obj.CRC || '';
    this.firstName = obj && obj.firstName || '';
    this.lastName = obj && obj.lastName || '';
    this.address = obj && obj.address || '';
    this.city = obj && obj.city || '';
    this.phone = obj && obj.phone || '';
  }
}

export class TicketPurchaseModel {
  id: number;
  event_id: number;
  ticketsNumber: number;

  constructor(obj?: any) {
    this.id = obj && obj.id || 0;
    this.event_id = obj && obj.event_id || 0;
    this.ticketsNumber = obj && obj.ticketsNumber || 0;
  }
}

export class ResultModel {
  id: number;
  wallet: number;

  constructor(obj?: any) {
    this.id = obj && obj.id || 0;
    this.wallet = obj && obj.wallet || 0;
  }
}
