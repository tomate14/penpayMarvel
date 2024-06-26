import { RouterOutlet } from '@angular/router';
import { Component, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, ReactiveFormsModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'penpay-marvel';

  constructor(private router: Router) {}
  switchComponent(component: string) {
    if (component === 'characters') {
      this.router.navigate([`/${component}`]);
    } else if (component === 'history') {
      this.router.navigate([`/${component}`]);
    }
  }
}
