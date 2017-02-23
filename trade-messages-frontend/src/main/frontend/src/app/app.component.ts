import { Component } from '@angular/core';
import { Http } from '@angular/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  results: Array<Object> = [];

  constructor(private http: Http) {
    http.get("http://localhost:8080/messages").subscribe(result => this.results =result.json());
  }
}
