import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { CharacterResult, MarvelData } from '../models/marvel-character.model';

@Injectable({
    providedIn: 'root'
})
export class CharacterService {

    constructor(private httpClient: HttpClient) { }

    public getCharacters(offset:number): Observable<MarvelData> {
        return this.httpClient.get<MarvelData>(`http://localhost:8080/marvel/character?offset=${offset}`);
    }
    public getCharacter(idCharacter:number): Observable<CharacterResult> {
        return this.httpClient.get<CharacterResult>(`http://localhost:8080/marvel/character/${idCharacter}`);
    }

}  