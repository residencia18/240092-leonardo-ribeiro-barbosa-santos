import { ApplicationConfig, importProvidersFrom } from '@angular/core'
import { provideRouter } from '@angular/router';
import { routes } from './app-routing.module'
import { provideHttpClient } from '@angular/common/http';
import { getAuth, provideAuth}

const firebaseConfig = {
  apiKey: "AIzaSyAuQZwL8sUs7MzcU8ovl55V4PrOpuAFyOI",
  authDomain: "suino-angular-app.firebaseapp.com",
  projectId: "suino-angular-app",
  storageBucket: "suino-angular-app.appspot.com",
  messagingSenderId: "899256246333",
  appId: "1:899256246333:web:4ed95267691876acc44a54",
  measurementId: "G-EHYEY9PLDL"
};


export const appConfig: ApplicationConfig = {
  providers: [provideRouter(routes),
     provideHttpClient(),
     importProvidersFrom([
      provideFireBaseApp(()=> initializeApp(firebaseConfig)),
      provideAuth(() => getAuth())
     ]),

  
  
};
