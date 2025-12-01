export const rules = {
  'enforce-service-suffix': {
    meta: {
      type: 'problem',
      docs: {
        description: 'Ensure service files end with Service.ts',
        recommended: true
      },
      schema: []
    },
    create(context) {
      const filename = context.getFilename();
      if (
        filename.includes('/services/') &&
        !filename.endsWith('Service.ts') &&
        !filename.endsWith('Service.tsx')
      ) {
        context.report({
          loc: { line: 1, column: 1 },
          message: 'Service files must end with "Service.ts"'
        });
      }
      return {};
    }
  }
};
