import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { HomeComponent } from './home/home.component';
import { UserLoginComponent } from './user-login/user-login.component';
import { ParentRegisterComponent } from './parent-register/parent-register.component';
import { ProviderRegisterComponent } from './provider-register/provider-register.component';

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
  { path: '',
    component: HomeComponent
  },
  { path: '**',
    component: HomeComponent
  }
];


@NgModule({
  imports: [RouterModule.forRoot(appRoutes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
