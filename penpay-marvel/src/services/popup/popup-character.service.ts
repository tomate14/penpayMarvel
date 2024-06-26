import { Injectable } from "@angular/core";
import { NgbModal, NgbModalOptions } from "@ng-bootstrap/ng-bootstrap";
import { CharacterDetailsComponent } from "../../app/popup/character-details/character-details.component";

@Injectable({
    providedIn: 'root'
  })
  export class PopupCharacterService { 
    constructor(private modalService: NgbModal) { }

    public openCharacter(character:any): void {
        const modalOptions: NgbModalOptions = {
            size: 'lg' // Establecer el tamaño del modal como grande (100% de la pantalla vertical)
        };

        const modalRef = this.modalService.open(CharacterDetailsComponent, modalOptions);
        modalRef.componentInstance.title = `${character.name} Details`;
        modalRef.componentInstance.character = character;

    }
  }