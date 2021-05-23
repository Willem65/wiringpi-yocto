#DEBUG	= -g -O0
#DEBUG	= -O2
CC	?= gcc
#INCLUDE	= -I$(DESTDIR)$(PREFIX)/include
#CFLAGS	= $(DEBUG) -Wall -Wextra $(INCLUDE) -Winline -pipe $(EXTRA_CFLAGS)
#LDFLAGS	= -L$(DESTDIR)$(PREFIX)/lib
#LIBS    = -lwiringPi -lwiringPiDev -lpthread -lrt -lm
# -lcrypt

LIBS    = -lwiringPi -lwiringPiDev

# May not need to  alter anything below this line
###############################################################################
SRC	=	gpio.c readall.c
OBJ	=	$(SRC:.c=.o)
all:		gpio

#version.h:	../VERSION
#	$Q echo Need to run newVersion above.

gpio:	$(OBJ)
	$Q echo [Link]
	$Q $(CC) -o $@ $(OBJ) $(LDFLAGS) $(LIBS)

.c.o:
	$Q echo [Compile] $<
	$Q $(CC) -c $(CFLAGS) $< -o $@

