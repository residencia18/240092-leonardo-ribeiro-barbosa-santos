import { HttpClient } from '@angular/common/http';
import { Component, inject } from '@angular/core';
import { FormBuilder, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  standalone: true,
  imports: [ReactiveFormsModule],
})
export class LoginComponent {
fb = inject(FormBuilder);
http = inject(HttpClient);
router = inject(Router);

form = this.fb.nonNullable.group({
  email: ['', Validators.required],
  password: ['', Validators.required],
});

onSubmit(): void {
  console.log('login');
}


}
