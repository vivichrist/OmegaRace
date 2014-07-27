#ifndef TYPEDEF_H_INCLUDED
#define TYPEDEF_H_INCLUDED

#define INCREMENT 0.02D
#define WHITE 0xFFFFFF
#define BLACK 0x000000
#define PLAYER_SIZE 10
#define BOXMARG_W 160
#define BOXMARG_H 165
#define WIDTH 640
#define HEIGHT 480

// re-order these to get them to draw in a different order
typedef enum { player, ufo, flyer, projectile, mine } Entity;

typedef struct point {
	Uint16 x, y;
} Point;

typedef struct gameEntity {
	double orientation;
	double direction;
	double speed;
	Entity type;
	Point point;
	struct gameEntity *next;
} GameEntity;


#endif
