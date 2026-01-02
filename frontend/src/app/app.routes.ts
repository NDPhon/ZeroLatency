import { Routes } from '@angular/router';
import { LoginComponent } from './auth/components/login/login.component';
import { AuthGuard } from './auth/guards/auth.guard';

export const routes: Routes = [
  // Landing page (home)
  {
    path: '',
    loadComponent: () =>
      import('./landing/landing.component').then((m) => m.LandingComponent),
    pathMatch: 'full',
  },

  // Auth routes (not protected)
  {
    path: 'auth',
    children: [
      {
        path: 'login',
        component: LoginComponent,
      },
      {
        path: 'register',
        loadComponent: () =>
          import('./auth/components/register/register.component').then((m) => m.RegisterComponent),
      },
    ],
  },

  // Protected routes (use AuthGuard)
  {
    path: 'dashboard',
    loadComponent: () =>
      import('./dashboard/dashboard.component').then((m) => m.DashboardComponent),
    canActivate: [AuthGuard],
  },

  // Catch-all (unknown routes go to landing)
  {
    path: '**',
    redirectTo: '',
  },
];