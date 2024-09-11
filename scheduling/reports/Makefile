all: publications.pdf

publications.pdf: publications.tex ../graphviz/fdp.pdf
	rm -f publications.pdf
	-lualatex --interaction=nonstopmode publications
	-lualatex --interaction=nonstopmode publications
	-lualatex --interaction=nonstopmode publications
	

clean:
	rm -f publications.pdf
