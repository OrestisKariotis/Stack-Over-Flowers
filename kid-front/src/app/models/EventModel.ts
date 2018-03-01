export class EventRegisterModel {
  event_id: number;
  provider_id: number;
  title: string;
  date: string;
  startingTime: string;
  address: string;
  description: string;
  categories: string;
  ticketCost: number;
  initTickets: number;
  lowestAge: number;
  highestAge: number;

  constructor ( obj?: any) {
    this.event_id = obj && obj.event_id || 0;
    this.provider_id = obj && obj.provider_id || 0;
    this.title = obj && obj.title || '';
    this.date = obj && obj.date || '';
    this.startingTime = obj && obj.startingTime || '';
    this.address = obj && obj.address || '';
    this.description = obj && obj.description || '';
    this.categories = obj && obj.categories || '';
    this.ticketCost = obj && obj.ticketCost || 0;
    this.initTickets = obj && obj.initTickets || 0;
    this.lowestAge = obj && obj.lowestAge || 0;
    this.highestAge = obj && obj.highestAge || 0;
  }
}

export class EventModel extends EventRegisterModel {

  businessName: string;
  availTickets: number;
  longtitude: number;
  latitude: number;

  constructor(obj?: any) {
    if (obj) {
      super(obj);
    } else {
      super();
    }
    this.businessName = obj && obj.businessName || '';
    this.availTickets = obj && obj.availTickets || 0;
    this.longtitude = obj && obj.longtitude || 0;
    this.latitude = obj && obj.latitude || 0;
  }
}
