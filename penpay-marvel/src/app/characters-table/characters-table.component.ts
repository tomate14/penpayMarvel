import { NgFor } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { CharacterService } from '../../services/character.service';
import { PopupCharacterService } from '../../services/popup/popup-character.service';
import { NgbPaginationModule } from '@ng-bootstrap/ng-bootstrap';
import { NgxSpinnerModule, NgxSpinnerService  } from 'ngx-spinner';

@Component({
  selector: 'app-characters-table',
  standalone: true,
  imports: [NgFor, NgbPaginationModule, NgxSpinnerModule],
  templateUrl: './characters-table.component.html',
  styleUrl: './characters-table.component.css'
})
export class CharactersTableComponent implements OnInit {
  characters:any;
  total = 0;
  limit = 20;
  page = 1;

  constructor(private characterService:CharacterService, private characterModal:PopupCharacterService, private spinner: NgxSpinnerService){

  }
  ngOnInit(): void {
    this.spinner.show();
    this.characterService.getCharacters(0).subscribe((res:any)=> {
      this.characters = res.results;
      this.limit = res.limit;
      this.total = res.total;
      this.spinner.hide();
    }, (error)=> {
      console.log(error);
      this.spinner.hide();
    })
  }

  onClick(character:any): void {
    this.characterService.getCharacter(character.id).subscribe((marvelCharacter:any)=> {
      this.characterModal.openCharacter(marvelCharacter);
    })    
  }

  fetchCharacters(): void {
    this.spinner.show();
    const offset = (this.page - 1) * this.limit;
    this.characterService.getCharacters(offset).subscribe((res:any)=> {
      this.characters = res.results;
      this.limit = res.limit;
      this.total = res.total;
      this.spinner.hide();
    }, (error)=> {
      console.log(error);
      this.spinner.hide();
    })
  }

  onPageChange(page: number): void {
    this.page = page;
    this.fetchCharacters();
  }
}
