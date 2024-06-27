export interface Thumbnail {
    path: string;
    extension: string;
  }
  
  export interface ComicItem {
    resourceURI: string;
    name: string;
  }
  
  export interface Comics {
    available: number;
    collectionURI: string;
    items: ComicItem[];
    returned: number;
  }
  
  export interface SeriesItem {
    resourceURI: string;
    name: string;
  }
  
  export interface Series {
    available: number;
    collectionURI: string;
    items: SeriesItem[];
    returned: number;
  }
  
  export interface StoryItem {
    resourceURI: string;
    name: string;
    type: string;
  }
  
  export interface Stories {
    available: number;
    collectionURI: string;
    items: StoryItem[];
    returned: number;
  }
  
  export interface EventItem {
    resourceURI: string;
    name: string;
  }
  
  export interface Events {
    available: number;
    collectionURI: string;
    items: EventItem[];
    returned: number;
  }
  
  export interface Url {
    type: string;
    url: string;
  }
  
  export interface CharacterResult {
    id: number;
    name: string;
    description: string;
    modified: string;
    thumbnail: Thumbnail;
    resourceURI: string;
    comics: Comics;
    series: Series;
    stories: Stories;
    events: Events;
    urls: Url[];
  }
  
  export interface MarvelData {
    offset: number;
    limit: number;
    total: number;
    count: number;
    results: CharacterResult[];
  }
  