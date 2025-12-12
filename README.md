# clojure-practice

This repository is to pracetice Clojure.

## Setup

This project uses [Babashka](https://babashka.org/), a fast native Clojure scripting runtime.

### Installation

Install Babashka:

- macOS: `brew install borkdude/brew/babashka`
- Linux: See [installation guide](https://github.com/babashka/babashka#installation)
- Windows: Use scoop or download binaries

## Usage

### Running Tests

```bash
bb test
```

### Starting a REPL

```bash
bb repl
```

### Running the Main Namespace

```bash
bb run
```

### Using Leiningen

The project still includes `project.clj` for compatibility with Leiningen:

```bash
lein test
lein repl
```

## License

Copyright © 2023 eno314

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
<http://www.eclipse.org/legal/epl-2.0>.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at <https://www.gnu.org/software/classpath/license.html>.
