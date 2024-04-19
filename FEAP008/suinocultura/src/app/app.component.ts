import { CommonModule } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Component, inject } from '@angular/core';
import { RouterLink, RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  standalone: true,
  styleUrls: ['./app.component.css'],
  imports: [CommonModule, RouterOutlet, RouterLink],

})
export class AppComponent {
  title = 'suinocultura';
  http = inject(HttpClient);

  logout(): void {
    console.log('logout');
  }
}
