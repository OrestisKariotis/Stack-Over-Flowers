import { NgModule } from '@angular/core';
import { Routes, RouterModule, Router, NavigationEnd } from '@angular/router';

import { ParentProfGuardService, PointsGuardService, EventRegGuardService, ControlGuardService } from './services/guard.service';

import { HomeComponent } from './home/home.component';
import { UserLoginComponent } from './user-login/user-login.component';
import { ParentRegisterComponent } from './parent-register/parent-register.component';
import { ProviderRegisterComponent } from './provider-register/provider-register.component';
import { EventRegisterComponent } from './event-register/event-register.component';
import { SearchComponent } from './search/search.component';
import { FaqComponent } from './faq/faq.component';
import { AboutUsComponent } from './about-us/about-us.component';
import { ContactComponent } from './contact/contact.component';
import { TermsComponent } from './terms/terms.component';
import { ErrorComponent } from './error/error.component';
import { PointsComponent } from './points/points.component';
import { ParentProfileComponent } from './parent-profile/parent-profile.component';
import { ProviderProfileComponent } from './provider-profile/provider-profile.component';
import { AdminLoginComponent } from './admin-login/admin-login.component';
import { ControlPanelComponent } from './control-panel/control-panel.component';
import { EventPageComponent } from './event-page/event-page.component';

const appRoutes: Routes = [
  { path: 'home',
    component: HomeComponent
  },
  { path: 'user-login',
    component: UserLoginComponent
  },
  { path: 'parent-register',
    component: ParentRegisterComponent
  },
  { path: 'provider-register',
    component: ProviderRegisterComponent
  },
  { path: 'event-register',
    component: EventRegisterComponent,
    canActivate: [EventRegGuardService]
  },
  { path: 'search',
    component: SearchComponent
  },
  { path: 'faq',
    component: FaqComponent
  },
  { path: 'about-us',
    component: AboutUsComponent
  },
  { path: 'contact',
    component: ContactComponent
  },
  { path: 'terms',
    component: TermsComponent
  },
  { path: 'points',
    component: PointsComponent,
    canActivate: [PointsGuardService]
  },
  { path: 'parent-profile/:id',
    component: ParentProfileComponent,
    canActivate: [ParentProfGuardService]
  },
  { path: 'provider-profile/:id',
    component: ProviderProfileComponent
  },
  { path: 'event-page/:id',
    component: EventPageComponent
  },
  { path: 'adminlogin',
    component: AdminLoginComponent
  },
  { path: 'control-panel',
    component: ControlPanelComponent,
    canActivate: [ControlGuardService]
  },
  { path: 'error',
    component: ErrorComponent
  },
  { path: '',
    component: HomeComponent
  },
  { path: '**',
    component: ErrorComponent
  }
];


@NgModule({
  imports: [RouterModule.forRoot(appRoutes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
  constructor(private router: Router) {

  this.router.events.subscribe(() => {
      window.scroll(0, 0);
    });

  }
}
