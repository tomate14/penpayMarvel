import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";

@Injectable({
    providedIn: 'root'
})
export class HistoryService {

    constructor(private httpClient: HttpClient) { }

    public getHistory(): Observable<any> {
        return this.httpClient.get<any>(`http://localhost:8080/marvel/history`);
    }

}  