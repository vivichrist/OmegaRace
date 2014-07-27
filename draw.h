#ifndef DRAW_H_INCLUDED
#define DRAW_H_INCLUDED

void drawBoundaries( SDL_Surface* );

void drawPlayer( SDL_Surface * ,Point * , double );

void drawEntities( SDL_Surface *, GameEntity * );

#endif // end DRAW_H_INCLUDED

