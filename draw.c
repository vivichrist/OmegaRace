#include "include.h"

void drawBoundaries( SDL_Surface* screen )
{
	/* Inner */
	sge_Rect( screen, BOXMARG_W, BOXMARG_H,
			WIDTH-BOXMARG_W-1, HEIGHT-BOXMARG_H-1, WHITE );
	// Outer
	sge_Rect( screen, 0, 0, WIDTH-1, HEIGHT-1, WHITE );
}
// Player is V shaped
void drawPlayer( SDL_Surface *screen ,
				 Point *p,
				 double direction )
{
	double dirx = PLAYER_SIZE * cos( direction );
	double diry = PLAYER_SIZE * sin( direction );
	double tailx = PLAYER_SIZE * cos( direction + ( M_PI*3.0D/4.0D ));
	double taily = PLAYER_SIZE * sin( direction + ( M_PI*3.0D/4.0D ));
	sge_AALine( screen, p->x + dirx, p->y + diry,
				p->x + tailx, p->y + taily, WHITE );
	sge_AALine( screen, p->x, p->y,
				p->x + tailx, p->y + taily, WHITE );
	tailx = PLAYER_SIZE * cos( direction + ( M_PI*5.0D/4.0D ));
	taily = PLAYER_SIZE * sin( direction + ( M_PI*5.0D/4.0D ));
	sge_AALine( screen, p->x + dirx, p->y + diry,
				p->x + tailx, p->y + taily
				, WHITE );
	sge_AALine( screen, p->x, p->y,
				p->x + tailx, p->y + taily
				, WHITE );
}

void drawUFO( SDL_Surface *screen, Point *p, double rotation )
{
	int i;
	for ( i=0; i < 8; ++i )
	{
		double angle = rotation + (M_PI/4.0D)*(double)i;
		double angle2 = rotation + ((M_PI/4.0D)*(double)(i+1));
		sge_AATrigon( screen, p->x, p->y,
					p->x + PLAYER_SIZE*.7D*cos( angle ),
					p->y + PLAYER_SIZE*.7D*sin( angle ),
					p->x + PLAYER_SIZE*cos( angle2 ),
					p->y + PLAYER_SIZE*sin( angle2 ),
					WHITE );
	}
}

void drawEntities( SDL_Surface *screen, GameEntity *gq )
{
	for ( ; gq; gq=gq->next )
	{	switch ( gq->type ) {
			case player:
				drawPlayer( screen, &gq->point, gq->orientation );
				break;
			case ufo:
				drawUFO( screen, &gq->point, gq->orientation );
				gq->orientation += 0.02D;
				break;
			case flyer:
			case projectile:
			case mine:
				;
		}
	}
}
