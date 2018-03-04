export class PendingEventModel {  //selida provider profile, tab4
  title: string;
  date: string;
  starting_time: string;
  ticket_cost: number;
  categories: string;

  constructor ( obj?: any) {
    this.title = obj && obj.title || '';
    this.date = obj && obj.date || '';
    this.starting_time = obj && obj.startingTime || '';
    this.categories = obj && obj.categories || '';
    this.ticket_cost = obj && obj.ticketCost || 0;
  }
}

export class HistoryEventModel extends PendingEventModel {  //selida provider profile, tab4
  initial_ticketsNumber: number;
  sold_ticketsNumber: number;

  constructor ( obj?: any) {
    if (obj) {
      super(obj);
    } else {
      super();
    }
    this.initial_ticketsNumber = obj && obj.initial_ticketsNumber || 0;
    this.sold_ticketsNumber = obj && obj.sold_ticketsNumber || 0;
  }
}

export class ProviderViewEventModel extends PendingEventModel { //selida provider profile, tab2, tab5
  event_id: number;
  description: string;
  initial_ticketsNumber: number;
  available_ticketsNumber: number;

  constructor ( obj?: any) {
    if (obj) {
      super(obj);
    } else {
      super();
    }
    this.event_id = obj && obj.event_id || 0;
    this.description = obj && obj.description || '';
    this.initial_ticketsNumber = obj && obj.initial_ticketsNumber || 0;
    this.available_ticketsNumber = obj && obj.available_ticketsNumber || 0;
  }
}

export class SearchEventModel extends PendingEventModel { //selida search
  description: string;
  event_id: number;
  longitude: number;
  latitude: number;
  location: {
    lon: number;
    lat: number;
  };

  constructor (obj?: any) {
    if (obj) {
      super(obj);
    } else {
      super();
    }
    this.event_id = obj && obj.event_id || 0;
    this.description = obj && obj.description || '';
    this.longitude = obj && obj.longitude || 0;
    this.latitude = obj && obj.latitude || 0;
    this.location.lat = obj && obj.location.lat || 0;
    this.location.lon = obj && obj.location.lon || 0;
  }

  flatLoc(sem: SearchEventModel) {
    sem.longitude = sem.location.lon;
    sem.latitude = sem.location.lat;
    return sem;
  }
}

export class EventRegisterModel extends PendingEventModel {
  event_id: number;
  provider_id: number;
  place: string;
  description: string;
  initial_ticketsNumber: number;
  lowestAge: number;
  highestAge: number;

  constructor ( obj?: any) {
    if (obj) {
      super(obj);
    } else {
      super();
    }
    this.event_id = obj && obj.event_id || 0;
    this.provider_id = obj && obj.provider_id || 0;
    this.place = obj && obj.place || '';
    this.description = obj && obj.description || '';
    this.initial_ticketsNumber = obj && obj.initial_ticketsNumber || 0;
    this.lowestAge = obj && obj.lowestAge || 0;
    this.highestAge = obj && obj.highestAge || 0;
  }
}

export class EventModel extends EventRegisterModel {  //selida admin, current tab,pending tab , selida event

  businessName: string;
  available_ticketsNumber: number;
  longitude: number;
  latitude: number;

  constructor(obj?: any) {
    if (obj) {
      super(obj);
    } else {
      super();
    }
    this.businessName = obj && obj.businessName || '';
    this.available_ticketsNumber = obj && obj.available_ticketsNumber || 0;
    this.longitude = obj && obj.longitude || 0;
    this.latitude = obj && obj.latitude || 0;
  }
}
