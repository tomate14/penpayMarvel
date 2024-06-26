import { NgFor, NgIf } from '@angular/common';
import { Component, Input } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-character-details',
  standalone: true,
  imports: [NgIf, NgFor],
  templateUrl: './character-details.component.html',
  styleUrl: './character-details.component.css'
})
export class CharacterDetailsComponent {
  @Input() character:any;
  @Input() title:string | undefined;

  constructor(private activeModal: NgbActiveModal) {   }

  ngOnInit() {
  }

  getFullImagePath(thumbnail: any): string {
    if (thumbnail && thumbnail.path && thumbnail.extension) {
      return `${thumbnail.path}.${thumbnail.extension}`;
    }
    return '';
  }

  public dismiss() {
    this.activeModal.close(false);
  }

  getCharacterSeriesParticipation(series:any) {
    const seriesName: any[] = []
    if (series.items) {
      series.items.forEach((item: { name: any; })=> {
        seriesName.push(item.name);
      })
    }
    return seriesName;
  }

  getCharacterDetailUrl(urls:any, type:string) {
    let url = 'No data retrieve';
    urls.forEach((urlObject: { type: string; url: any; })=> {
      if (urlObject.type === type) {
        url = urlObject.url;
      }
    })
    return url;
  }
}
