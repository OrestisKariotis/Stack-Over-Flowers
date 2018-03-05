export class ParentCP {     // CP Tab 1
  id: number;
  username: string;
  firstname: string;
  lastname: string;
  email: string;
  phone: string;
  wallet: number;
  spent_points: number;
  ban: boolean;

  constructor ( obj?: any) {
    this.id = obj && obj.id || 0;
    this.username = obj && obj.username || '';
    this.firstname = obj && obj.firstname || '';
    this.lastname = obj && obj.lastname || '';
    this.email = obj && obj.email || '';
    this.phone = obj && obj.phone || '';
    this.wallet = obj && obj.wallet || 0;
    this.spent_points = obj && obj.spent_points || 0;
    this.ban = obj && obj.ban || false;
  }
}

export class PendProviderCP {     // CP Tab 3
  id: number;
  username: string;
  firstname: string;
  lastname: string;
  email: string;
  phone: string;
  businessName: string;

  constructor ( obj?: any) {
    this.id = obj && obj.id || 0;
    this.username = obj && obj.username || '';
    this.firstname = obj && obj.firstname || '';
    this.lastname = obj && obj.lastname || '';
    this.email = obj && obj.email || '';
    this.phone = obj && obj.phone || '';
    this.businessName = obj && obj.businessName || '';
  }
}

export class ProviderCP extends PendProviderCP {    // CP Tab 2
  profit: number;
  rights_code: number;

  constructor ( obj?: any) {
    if (obj) {
      super(obj);
    } else {
      super();
    }
    this.profit = obj && obj.profit || 0;
    this.rights_code = obj && obj.rights_code || 0;
  }
}

export class PendEventCP {    // CP Tab 5
  event_id: number;
  title: string;
  businessName: string;
  date: string;
  starting_time: string;
  description: string;
  categories: string;
  place: string;
  ticket_cost: number;
  lowestAge: number;
  highestAge: number;
  initial_ticketsNumber: number;

  constructor ( obj?: any) {
    this.event_id = obj && obj.event_id || 0;
    this.title = obj && obj.title || '';
    this.businessName = obj && obj.businessName || '';
    this.date = obj && obj.date || '';
    this.starting_time = obj && obj.startingTime || '';
    this.description = obj && obj.description || '';
    this.categories = obj && obj.categories || '';
    this.place = obj && obj.place || '';
    this.ticket_cost = obj && obj.ticketCost || 0;
    this.lowestAge = obj && obj.lowestAge || 0;
    this.highestAge = obj && obj.highestAge || 0;
    this.initial_ticketsNumber = obj && obj.initial_ticketsNumber || 0;
  }
}

export class EventCP extends PendEventCP {    // CP Tab 4
  available_ticketsNumber: number;

  constructor ( obj?: any) {
    if (obj) {
      super(obj);
    } else {
      super();
    }
    this.available_ticketsNumber = obj && obj.available_ticketsNumber || 0;
  }
}

export class TotalStatsCP {
  numOfParents: number;
  numOfProviders: number;
  profit: number;

  constructor ( obj?: any) {
    this.numOfParents = obj && obj.numOfParents || 0;
    this.numOfProviders = obj && obj.numOfProviders || 0;
    this.profit = obj && obj.profit || 0;
  }
}

export class MonthlyStatsCP {
  month: number;
  earnings: number;
  expenses: number;
  profit: number;

  constructor ( obj?: any) {
    this.month = obj && obj.month || 0;
    this.earnings = obj && obj.earnings || 0;
    this.expenses = obj && obj.expenses || 0;
    this.profit = obj && obj.profit || 0;
  }
}
